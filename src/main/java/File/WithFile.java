package File;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 类：File,Path,FileStore,Files
 * 获取某个目录下的所有文件，获取文件的某些属性，如创建时间等
 */
public class WithFile {
    public static void main(String[] args){
        File directory = new File("E:\\学习视频\\基础部分\\JDKAPI18CN");
        Set<File> files = performListing(directory);
        for(File file: files){
            Map<String, String> attributes = getAttributeFromFile(file.toPath());
            for(String key:attributes.keySet()){
                System.out.println(key+":"+attributes.get(key));
            }
            System.out.println("====================");
        }


    }

    //返回某个目录下的所有文件
    public static Set<File> performListing(File directory){
        Path p = directory.toPath();
        if (!Files.isWritable(p) || !Files.isReadable(p)) {
            throw new IllegalStateException("Directory '" + directory + "' does not have sufficient permissions (i.e., not writable and readable)");
        }
        final Set<File> queue = new HashSet<>();
        if (!directory.exists()) {
            return queue;
        }

        File[] children = directory.listFiles();
        if (children == null) {
            return queue;
        }
        for (final File child : children) {
            if (child.isDirectory()) {
                queue.addAll(performListing(child));

            } else {
                queue.add(child);
            }
        }
        return queue;
    }

    public static final String FILE_CREATION_TIME_ATTRIBUTE = "file.creationTime";
    public static final String FILE_LAST_MODIFY_TIME_ATTRIBUTE = "file.lastModifiedTime";
    public static final String FILE_LAST_ACCESS_TIME_ATTRIBUTE = "file.lastAccessTime";
    public static final String FILE_OWNER_ATTRIBUTE = "file.owner";
    public static final String FILE_GROUP_ATTRIBUTE = "file.group";
    public static final String FILE_PERMISSIONS_ATTRIBUTE = "file.permissions";
    public static final String FILE_MODIFY_DATE_ATTR_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    //返回某个文件的属性，输入参数是Path
    public static  Map<String,String> getAttributeFromFile(Path file){
        Map<String, String> attributes = new HashMap<>();
        try {
            FileStore store = Files.getFileStore(file);
            if (store.supportsFileAttributeView("basic")) {
                try {
                    final DateFormat formatter = new SimpleDateFormat(FILE_MODIFY_DATE_ATTR_FORMAT, Locale.US);
                    BasicFileAttributeView view = Files.getFileAttributeView(file, BasicFileAttributeView.class);
                    BasicFileAttributes attrs = view.readAttributes();
                    attributes.put(FILE_LAST_MODIFY_TIME_ATTRIBUTE, formatter.format(new Date(attrs.lastModifiedTime().toMillis())));
                    attributes.put(FILE_CREATION_TIME_ATTRIBUTE, formatter.format(new Date(attrs.creationTime().toMillis())));
                    attributes.put(FILE_LAST_ACCESS_TIME_ATTRIBUTE, formatter.format(new Date(attrs.lastAccessTime().toMillis())));
                } catch (Exception ignore) {
                } // allow other attributes if these fail
            }
            if (store.supportsFileAttributeView("owner")) {
                try {
                    FileOwnerAttributeView view = Files.getFileAttributeView(file, FileOwnerAttributeView.class);
                    attributes.put(FILE_OWNER_ATTRIBUTE, view.getOwner().getName());
                } catch (Exception ignore) {
                } // allow other attributes if these fail
            }
            if (store.supportsFileAttributeView("posix")) {
                try {
                    PosixFileAttributeView view = Files.getFileAttributeView(file, PosixFileAttributeView.class);
                    attributes.put(FILE_PERMISSIONS_ATTRIBUTE, PosixFilePermissions.toString(view.readAttributes().permissions()));
                    attributes.put(FILE_GROUP_ATTRIBUTE, view.readAttributes().group().getName());
                } catch (Exception ignore) {
                } // allow other attributes if these fail
            }
        } catch (IOException ioe) {
            // well then this FlowFile gets none of these attributes
        }

        return attributes;
    }
}
