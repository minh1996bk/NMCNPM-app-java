package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Export {

	    public static PdfPTable getTable(JTable table) throws DocumentException, IOException {
	        BaseFont bf1 = BaseFont.createFont("vuTimes.ttf", BaseFont.IDENTITY_H, true);
	        Font fontBang = new Font(bf1, 10, Font.NORMAL, BaseColor.BLACK);
	        Font fontCot = new Font(bf1, 12, Font.BOLD, BaseColor.BLUE);
	        int numColumm = table.getColumnCount();
	        // set for first line
	        PdfPTable pdfTable = new PdfPTable(numColumm);
	        for (int i = 0; i < numColumm; i++) {
	            PdfPCell cell = new PdfPCell(new Paragraph(table.getColumnName(i), fontCot));
	            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            pdfTable.addCell(cell);
	        }
	        for (int i = 0; i < table.getRowCount(); i++) {
	            for (int j = 0; j < table.getColumnCount(); j++) {
	                PdfPCell cell = new PdfPCell(new Paragraph("" + table.getValueAt(i, j), fontBang));
	                pdfTable.addCell(cell);
	            }
	        }
	        return pdfTable;
	    }

	    public static boolean PrintStatistics(JTable table, String path, String name, String Admin, int month ,int year) {
	        boolean isSuccess = false;
	        try {
	            BaseFont bf1 = BaseFont.createFont("vuTimes.ttf", BaseFont.IDENTITY_H, true);
	            Document document = new Document();
	            PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
	            document.open();
	            Font fontTenThuVien = new Font(bf1, 35, Font.BOLD, BaseColor.RED);
	            Font fontTieuDe = new Font(bf1, 20, Font.BOLD, BaseColor.BLACK);
	            Font fontChung = new Font(bf1, 14, Font.NORMAL, BaseColor.BLACK);
	            Font fontChuKy = new Font(bf1, 16, Font.BOLD, BaseColor.BLACK);
	            Font fontLienLac = new Font(bf1, 6, Font.UNDEFINED, BaseColor.BLACK);
	            document.add(new Paragraph("      THƯ VIỆN TẠ QUANG BỬU", fontTenThuVien));
	            document.add(new Paragraph(" ", fontChuKy));
	            document.add(new Paragraph("Đại học Bách Khoa Hà Nội - Số 1 Đại Cồ Việt - Hai Bà Trưng - Hà Nội                                                                                                                                                                                                      SĐT: 0969991097", fontLienLac));
	            document.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------", fontLienLac));
	            document.add(new Paragraph("                                  PHIẾU THỐNG KÊ", fontTieuDe));
	            document.add(new Paragraph("                               ", fontTieuDe));
	            document.add(new Paragraph("Nội dung thống kê      : " + name, fontChung));
	            if(name.equals("TOP ĐỘC GIẢ MƯỢN NHIỀU SÁCH NHẤT") || name.equals("TOP SÁCH ĐƯỢC MƯỢN NHIỀU NHẤT")){
	                document.add(new Paragraph("Tháng      : " + (month + 1), fontChung));
	                document.add(new Paragraph("Năm        : " + year, fontChung));
	            }
	            document.add(new Paragraph("Ngày thống kê          : " + new java.sql.Date(new Date().getTime()), fontChung));
	            document.add(new Paragraph("Tên nhân viên thống kê : " + Admin, fontChung));
	            document.add(new Paragraph(" ", fontChung));
	            PdfPTable table2 = getTable(table);
	            document.add(table2);
	            document.add(new Paragraph(" ", fontChung));
	            document.add(new Paragraph(" ", fontChung));
	            document.add(new Paragraph("                                                               Chữ ký cán bộ và đóng dấu ", fontChuKy));
	            document.close();
	            isSuccess = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            isSuccess = false;
	        }
	        return isSuccess;
	    }
	    //print report
	    public static boolean printreport(JTable table, String path, String name, String Admin,String total) {
	        boolean isSuccess = false;
	        try {
	            BaseFont bf1 = BaseFont.createFont("vuTimes.ttf", BaseFont.IDENTITY_H, true);
	            Document document = new Document();
	            PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
	            document.open();
	            Font fontName = new Font(bf1, 32, Font.BOLD, BaseColor.RED);
	            Font fontTieuDe = new Font(bf1, 20, Font.BOLD, BaseColor.BLACK);
	            Font fontChung = new Font(bf1, 14, Font.NORMAL, BaseColor.BLACK);
	            Font fontChuKy = new Font(bf1, 16, Font.BOLD, BaseColor.BLACK);
	            Font fontLienLac = new Font(bf1, 8, Font.UNDEFINED, BaseColor.BLACK);
	            document.add(new Paragraph("                          HÓA ĐƠN ", fontName));
	            document.add(new Paragraph(" ", fontChuKy));
	            document.add(new Paragraph("Cửa Hàng Quần Áo Thời Trang_ Boutique_69 Trần Đại Nghĩa                                                                                                                                                                                                      SĐT: 0973248051", fontLienLac));
	            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------", fontLienLac));
	            document.add(new Paragraph("                                       NHẬP KHO ", fontTieuDe));
	            document.add(new Paragraph("                               ", fontTieuDe));
	            document.add(new Paragraph("Tên nhân viên nhập kho : " + Admin, fontChung));
	            document.add(new Paragraph("Báo Cáo Theo          : " + name, fontChung));
	            document.add(new Paragraph("Ngày                  : " + new java.sql.Date(new Date().getTime()), fontChung));
	            document.add(new Paragraph("Kết quả           :", fontChung));
	            document.add(new Paragraph(" ", fontChung));
	            document.add(new Paragraph(" ", fontChung));
	            PdfPTable table2 = getTable(table);
	            document.add(table2);
	            document.add(new Paragraph("                                                            Tổng Giá trị: " +total,fontChuKy));
	            document.add(new Paragraph(" ", fontChung));
	            document.add(new Paragraph(" ", fontChung));
	            document.add(new Paragraph(" ", fontChung));
	            document.add(new Paragraph("                                                            Chữ ký cán bộ và đóng dấu ", fontChuKy));
	            document.close();
	            isSuccess = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            isSuccess = false;
	        }

	        return isSuccess;
	    }
	    //print receipt for customer
	    public static boolean printforcustomer(JTable table, String path,String Customer,String total) {
	        boolean isSuccess = false;
	        try {
	            BaseFont bf1 = BaseFont.createFont("vuTimes.ttf", BaseFont.IDENTITY_H, true);
	            Document document = new Document();
	            PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
	            document.open();
	            Font fontName = new Font(bf1, 35, Font.BOLD, BaseColor.RED);
	            Font fontTieuDe = new Font(bf1, 20, Font.BOLD, BaseColor.BLACK);
	            Font fontChung = new Font(bf1, 14, Font.NORMAL, BaseColor.BLACK);
	            Font fontChuKy = new Font(bf1, 16, Font.BOLD, BaseColor.BLACK);
	            Font fontLienLac = new Font(bf1, 8, Font.UNDEFINED, BaseColor.BLACK);
	            document.add(new Paragraph("                     HÓA ĐƠN ", fontName));
	            document.add(new Paragraph(" ", fontChuKy));
	            document.add(new Paragraph("Cửa Hàng Quần Áo Thời Trang_ Boutique_69 Trần Đại Nghĩa                                                                                                                                                                                                      SĐT: 0973248051", fontLienLac));
	            document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------", fontLienLac));
	            document.add(new Paragraph("                                     Danh sách vật phẩm", fontTieuDe));
	            document.add(new Paragraph("                               ", fontTieuDe));
	            document.add(new Paragraph("Tên khách hàng : " + Customer, fontChung));
	            document.add(new Paragraph("Ngày                  : " + new java.sql.Date(new Date().getTime()), fontChung));
	            document.add(new Paragraph(" ", fontChung));
	            document.add(new Paragraph(" ", fontChung));
	            PdfPTable table2 = getTable(table);
	            document.add(table2);
	            document.add(new Paragraph("                                                                   Tổng Giá trị: " +total,fontChuKy));
	            document.add(new Paragraph(" ", fontChung));
	            document.add(new Paragraph(" ", fontChung));
	            document.add(new Paragraph(" ", fontChung));
	            document.add(new Paragraph("                                                                     Chữ ký cán bộ và đóng dấu ", fontChuKy));
	            document.close();
	            isSuccess = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            isSuccess = false;
	        }

	        return isSuccess;
	    }
	    // export to excel
	    public void ExporttoExcel(JTable table) {
	        JFileChooser chooser = new JFileChooser();
	        int i = chooser.showSaveDialog(chooser);
	        if (i == JFileChooser.APPROVE_OPTION) {
	            File file = chooser.getSelectedFile();
	            try {
	                FileWriter out = new FileWriter(file + ".xls");
	                BufferedWriter bwrite = new BufferedWriter(out);
	                DefaultTableModel model = (DefaultTableModel) table.getModel();
	                // get name of column
	                for (int j = 0; j < table.getColumnCount(); j++) {
	                    bwrite.write(model.getColumnName(j) + "\t");
	                }
	                bwrite.write("\n");
	                // get data in row
	                for (int j = 0; j < table.getRowCount(); j++) {
	                    for (int k = 0; k < table.getColumnCount(); k++) {
	                        bwrite.write(model.getValueAt(j, k) + "\t");
	                    }
	                    bwrite.write("\n");
	                }
	                bwrite.close();
	                JOptionPane.showMessageDialog(null, "Save file successful!");
	            } catch (Exception e2) {
	                JOptionPane.showMessageDialog(null, "Save file ERROR!");
	            }
	        }
	    }
	}

