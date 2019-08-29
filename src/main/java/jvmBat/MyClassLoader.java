package jvmBat;


import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 自定义类加载器
 */
public class MyClassLoader extends ClassLoader {
    private final static Path DEFAULT_CLASS_DIR= Paths.get("f:","classloader");
    private final Path classDir;
    public MyClassLoader(){
        super();
        this.classDir=DEFAULT_CLASS_DIR;
    }
    public MyClassLoader(Path p){
        super();
        this.classDir=p;
    }

    public MyClassLoader(Path p,ClassLoader c){
        super(c);
        this.classDir=p;

    }
    //若要破坏双亲委派模型，则直接在这里加载
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = this.readClassBytes(name);
        return this.defineClass(name,classBytes,0,classBytes.length);
    }

    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if(!classFullPath.toFile().exists()){
            throw new ClassNotFoundException("meiyoufaxian");
        }
        try {
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            Files.copy(classFullPath,baos);
            return baos.toByteArray();

        }catch (Exception e){
            throw new ClassNotFoundException("meiyoufaxian");
        }
    }
}
