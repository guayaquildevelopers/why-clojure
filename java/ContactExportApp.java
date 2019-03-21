import java.util.ArrayList;

interface Exporter {
  public void export(ArrayList data, String filePath);
}

class CsvExporter implements Exporter {
  public void export(ArrayList data, String filePath) {
    System.out.println("Exporting to CSV...");
  }
}

class JsonExporter implements Exporter {
  public void export(ArrayList data, String filePath) {
    System.out.println("Exporting to JSON...");
  }
}

class FileExporterFactory {
  public static Exporter getExporter(String format) throws Exception {
    if (format.equals("csv")) {
      return new CsvExporter();
    } else if (format.equals("json")) {
      return new JsonExporter();
    } else {
      throw new Exception("Format not implemented");
    }
  }
}

class ContactExportApp {
  public static void main(String[] args) throws Exception {
    String format = args[0];
    ArrayList data = new ArrayList();
    Exporter exporter = FileExporterFactory.getExporter(format);
    String path = "/fake/path/contacts." + format;
    exporter.export(data, path);
    System.out.println("! Process complete");
  }
}