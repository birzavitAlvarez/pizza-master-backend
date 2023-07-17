package com.proyecto.app.spring.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.proyecto.app.spring.DTO.DetalleDTO;
import com.proyecto.app.spring.DTO.VentaDTO;
import com.proyecto.app.spring.entity.Detalle;
import com.proyecto.app.spring.entity.Venta;
import com.proyecto.app.spring.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.ByteArrayOutputStream;
import java.sql.Timestamp;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/venta")
public class VentaController {
    private static final Font TITLE_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font SUBTITLE_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
    private static final Font HEADER_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static final Font CELL_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
    @Autowired
    private VentaService ventaService;

    @Autowired
    private ModelMapper modelMapper;
    @GetMapping
    public ResponseEntity<?> readAll(){
        List<Venta> ventas=ventaService.findAll();
        List<VentaDTO> ventaDTOS=new ArrayList<>();
        for (Venta venta:ventas){
            VentaDTO ventaDTO=new VentaDTO(venta.getId(),venta.getFechaVenta(),venta.getSubTotalVenta(),venta.getIgvVenta()
            ,venta.getTotalVenta(),venta.getDetalles().stream().map(detalle-> modelMapper.map(detalle, DetalleDTO.class)).collect(Collectors.toSet()));
            ventaDTOS.add(ventaDTO);
        }
        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("status",200);
        respuesta.put("data",ventaDTOS);
        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable Long id){
        Optional<Venta> ventaOptional=ventaService.findById(id);
        if(!ventaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        VentaDTO ventaDTO=new VentaDTO(ventaOptional.get().getId(),ventaOptional.get().getFechaVenta(),
                ventaOptional.get().getSubTotalVenta(),ventaOptional.get().getIgvVenta()
                ,ventaOptional.get().getTotalVenta(),ventaOptional.get().getDetalles().stream().map(detalle-> modelMapper.map(detalle, DetalleDTO.class)).collect(Collectors.toSet()));

        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("status",200);
        respuesta.put("data",ventaDTO);
        return ResponseEntity.ok(respuesta);
    }
    private PdfPCell getCell(String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(3);
        return cell;
    }
    @GetMapping("/boleta/{id}")
    public ResponseEntity<?> generarBoleta(@PathVariable Long id) throws DocumentException {

            Optional<Venta> venta = ventaService.findById(id);
            if (!venta.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            Set<Detalle> detalles = venta.get().getDetalles();

            // Crear el documento PDF
            Document documento = new Document(PageSize.A4, 50, 50, 50, 50);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(documento, baos);
            documento.open();
            // Agregar contenido al PDF
            Paragraph title = new Paragraph("BOLETA DE VENTA", TITLE_FONT);
            title.setAlignment(Element.ALIGN_CENTER);
            documento.add(title);
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("Número de venta: " + venta.get().getId().toString(), HEADER_FONT));
            documento.add(new Paragraph("Fecha: " + venta.get().getFechaVenta().toString(), HEADER_FONT));
            documento.add(new Paragraph("\n"));

            // Agregar la tabla con los detalles de la venta
            PdfPTable tablaDetalles = new PdfPTable(4);
            tablaDetalles.setWidthPercentage(100);
            tablaDetalles.setSpacingBefore(10);
            tablaDetalles.setSpacingAfter(10);

            // Cabecera de la tabla
            tablaDetalles.addCell(getCell("Nombre", HEADER_FONT));
            tablaDetalles.addCell(getCell("Cantidad", HEADER_FONT));
            tablaDetalles.addCell(getCell("Precio", HEADER_FONT));
            tablaDetalles.addCell(getCell("Total", HEADER_FONT));

            // Detalles de la venta
            for (Detalle detalle : detalles) {
                tablaDetalles.addCell(getCell(detalle.getCarta().getNombreCarta(), CELL_FONT));
                tablaDetalles.addCell(getCell(String.valueOf(detalle.getCantidad()), CELL_FONT));
                tablaDetalles.addCell(getCell(detalle.getPrecio().toString(), CELL_FONT));
                tablaDetalles.addCell(getCell(detalle.getTotal().toString(), CELL_FONT));
            }

            documento.add(tablaDetalles);
            documento.add(new Paragraph("\n"));

            // Totales de la venta
            documento.add(new Paragraph("SubTotal: " + venta.get().getSubTotalVenta().toString(), SUBTITLE_FONT));
            documento.add(new Paragraph("IGV: " + venta.get().getIgvVenta().toString(), SUBTITLE_FONT));
            documento.add(new Paragraph("Total: "+ venta.get().getTotalVenta().toString(), SUBTITLE_FONT));
            documento.close();
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=boletaVenta.pdf")
                    .body(baos.toByteArray());

        }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Venta venta){
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        respuesta.put("data",ventaService.save(venta));
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Venta venta){
        Optional<Venta> ventaOptional=ventaService.findById(id);
        if(!ventaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        venta.setId(id);
        Timestamp fechaVenta = new Timestamp(System.currentTimeMillis());
        venta.setFechaVenta(fechaVenta);
        ventaService.save(venta);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Venta> ventaOptional=ventaService.findById(id);
        if(!ventaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        ventaService.deleteById(id);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
}
