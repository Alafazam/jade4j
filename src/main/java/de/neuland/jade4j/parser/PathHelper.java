package de.neuland.jade4j.parser;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

public class PathHelper {
    public String resolvePath(String parentName, String templateName, String basePath) {
//        Path currentPath = Paths.get(filename);
//        Path templatePath = Paths.get(templateName);
//        Path parent = currentPath.getParent();
//        String filePath = templatePath.toString();
//        if(parent!=null)
//            filePath = parent.resolve(templatePath).toString();
        String filePath;
        if(templateName.startsWith("/")) {
            filePath = basePath + templateName;
        }else {
            if (FilenameUtils.indexOfLastSeparator(parentName) == -1)
                filePath = templateName;
            else {
                //            String currentDir = FilenameUtils.getFullPath(parentName);
                String currentDir = parentName.substring(0, FilenameUtils.indexOfLastSeparator(parentName) + 1);
                filePath = currentDir + templateName;
            }
        }
        if(StringUtils.lastIndexOf(filePath,"/") >= StringUtils.lastIndexOf(filePath,"."))
            filePath += ".jade";
        filePath = FilenameUtils.normalize(filePath);
        return filePath;
    }
}
