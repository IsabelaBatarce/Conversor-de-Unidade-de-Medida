package code;

import converters.IConverterMaster;

import java.io.File;
import java.util.ArrayList;

public class LoadConverters {

    public static ArrayList<IConverterMaster> InstaceConverters() {
        ArrayList<IConverterMaster> listClasses = new ArrayList<>();

        String basePath = System.getProperty("user.dir");
        String dirPath = String.format("%s\\%s", basePath, "src\\converters\\");

        File dir = new File(dirPath);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                try {
                    if (child.getName().contains("Converter") && !child.getName().startsWith("I")) {
                        String classFileName = String.format("%s.%s", "converters", child.getName().replaceAll("\\.\\w+", ""));
                        listClasses.add((IConverterMaster) Class.forName(classFileName).newInstance());
                    }
                } catch (InstantiationException e) {
                    System.out.println("\nError instancing class. " + e.getMessage());
                } catch (IllegalAccessException e) {
                    System.out.println("\nError accessing class. " + e.getMessage());
                } catch (ClassNotFoundException e) {
                    System.out.println("\nClass not found. " + e.getMessage());
                }
            }
        }

        return listClasses;
    }
}
