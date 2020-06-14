package Modelo;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Generador de reportes
 *
 * Genera reportes especificos, por ejemlplo el de los cobros
 *
 * @author Jaasiel Guerra
 */
public class GenerarReporte {

	private String total;

	public void generarReporte(String titulo, ArrayList<ArrayList<String>> datos, ArrayList<String> cab, String user,
			String total, String faltante, String sobrante, String diferencia) {

		this.total = total;

		JFileChooser save = new JFileChooser();

		save.setDialogTitle("Guardar Reporte PDF");
		FileFilter filter = new FileNameExtensionFilter("Archivo PDF", "pdf");
		save.setAcceptAllFileFilterUsed(false);
		save.setFileFilter(filter);

		int option = save.showSaveDialog(null);

		if (option == JFileChooser.APPROVE_OPTION) {
			try {
				Document doc = new Document(PageSize.LETTER, 40, 40, 20, 20);
				String path = save.getSelectedFile().getAbsoluteFile() + "";
				if (!path.substring(path.length() - 3, path.length()).equals("pdf")) {
					path = path + ".pdf";
				}

				PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(path));
				// writer.setPageEvent(this);

				doc.open();

				// Parrafo vacio
				Paragraph vacio = new Paragraph("\n",
						FontFactory.getFont(FontFactory.COURIER_BOLD, 5, BaseColor.BLACK));

				// INICIO REPORTE
				// Titulo 2
				// Paragraph parrafo = new Paragraph(titulo2 + " \n\n",
				// FontFactory.getFont(FontFactory.COURIER_BOLD, 14, BaseColor.BLACK));
				// parrafo.setAlignment(Element.ALIGN_CENTER);
				// doc.add(parrafo);

				// Titulo 1
				PdfPTable tabla = new PdfPTable(1);
				tabla.setTotalWidth(PageSize.LETTER.getWidth() - 80);
				tabla.setLockedWidth(true);

				PdfPCell celda = new PdfPCell(new Paragraph(titulo,
						FontFactory.getFont(FontFactory.COURIER, 15, Font.BOLD, BaseColor.WHITE)));
				celda.setFixedHeight(25);
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setVerticalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.BLACK);
				tabla.addCell(celda);
				doc.add(tabla);
				doc.add(vacio);

				//Tabla Datos
				tabla = new PdfPTable(1);
				tabla.setTotalWidth(PageSize.LETTER.getWidth() - 80);
				tabla.setLockedWidth(true);

				Calendar c = Calendar.getInstance();
				SimpleDateFormat format = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy 'a las' hh:mm a");

				celda = new PdfPCell(new Paragraph("Generado el " + format.format(c.getTime()),
						FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK)));
				celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
				celda.setVerticalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.WHITE);
				celda.setPadding(8);
				tabla.addCell(celda);
				doc.add(tabla);
				doc.add(vacio);

				// totales
				tabla = new PdfPTable(4);
				tabla.setTotalWidth(PageSize.LETTER.getWidth() - 80);
				tabla.setLockedWidth(true);
				
				celda = new PdfPCell(new Paragraph("Falta: " + faltante,
						FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD, BaseColor.WHITE)));
				celda.setFixedHeight(18);
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				celda.setVerticalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(new BaseColor(158, 158, 158));
				celda.setBorder(0);
				tabla.addCell(celda);
				
				celda = new PdfPCell(new Paragraph("Sobra: " + sobrante,
						FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD, BaseColor.WHITE)));
				celda.setFixedHeight(18);
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				celda.setVerticalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(new BaseColor(158, 158, 158));
				celda.setBorder(0);
				tabla.addCell(celda);
				
				celda = new PdfPCell(new Paragraph("Dif.: " + diferencia,
						FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD, BaseColor.WHITE)));
				celda.setFixedHeight(18);
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				celda.setVerticalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(new BaseColor(158, 158, 158));
				celda.setBorder(0);
				tabla.addCell(celda);
				
				celda = new PdfPCell(new Paragraph("Tot.: " + total,
						FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD, BaseColor.WHITE)));
				celda.setFixedHeight(18);
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				celda.setVerticalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(new BaseColor(158, 158, 158));
				celda.setBorder(0);
				tabla.addCell(celda);
				
				doc.add(tabla);
				doc.add(vacio);

				// Cabecera de tabla
				tabla = new PdfPTable(cab.size());
				tabla.setTotalWidth(PageSize.LETTER.getWidth() - 80);
				tabla.setLockedWidth(true);

				for (int i = 0; i < cab.size(); i++) {
					celda = new PdfPCell(new Paragraph(cab.get(i),
							FontFactory.getFont(FontFactory.COURIER, 10, Font.BOLD, BaseColor.WHITE)));
					celda.setFixedHeight(20);
					celda.setHorizontalAlignment(Element.ALIGN_CENTER);
					celda.setVerticalAlignment(Element.ALIGN_CENTER);
					celda.setBackgroundColor(new BaseColor(51, 139, 204));
					celda.setBorderColor(BaseColor.WHITE);
					celda.setBorderWidth(0);
					tabla.addCell(celda);
				}

				// Datos de Tabla
				for (int i = 0; i < datos.size(); i++) {
					for (int j = 0; j < datos.get(i).size(); j++) {
						celda = new PdfPCell(new Paragraph(datos.get(i).get(j),
								FontFactory.getFont(FontFactory.COURIER, 7, Font.PLAIN, BaseColor.BLACK)));
						celda.setFixedHeight(12);
						celda.setHorizontalAlignment(Element.ALIGN_CENTER);
						celda.setVerticalAlignment(Element.ALIGN_MIDDLE);

//                        if (i % 2 == 0) {
//                            celda.setBackgroundColor(BaseColor.WHITE);
//                            celda.setBorderColor(BaseColor.WHITE);
//                        } else {
						celda.setBackgroundColor(new BaseColor(255, 255, 255));
						celda.setBorderColor(new BaseColor(228, 239, 248));
//                        }
						tabla.addCell(celda);
					}
				}
				doc.add(tabla);
				doc.close();
			} catch (DocumentException | IOException ex) {

				JOptionPane.showMessageDialog(null, "Error al generar el PDF\n" + "Causa: " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

//    @Override
//    public void onEndPage(PdfWriter writer, Document document) {
//
//        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT,
//                new Phrase("TOTAL: " + total, FontFactory.getFont(FontFactory.COURIER_BOLD,
//                        12, new BaseColor(46, 125, 50))), 570, 18, 0);
//
//    }
}
