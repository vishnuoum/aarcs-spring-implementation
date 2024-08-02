package com.app.aarcs.util;

import com.app.aarcs.settings.ServiceManager;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.time.Instant;

public class FileUtil {

	private FileUtil() {}

	public static String saveFile(MultipartFile image, String folder) {
		if(!image.isEmpty()) {
			try {
				String fileName = "%d-%s".formatted(Instant.now().getEpochSecond(), image.getOriginalFilename());
				String filePath = "%s/%s/%s/%s".formatted(System.getProperty("user.home"), "uploads", folder,
						fileName);
				image.transferTo(Paths.get(filePath));
				return "http://localhost:3000/%s/%s".formatted(folder, fileName);
			} catch (Exception e) {
				LoggingUtil.printInfo(FileUtil.class, "Error saving the file");
				LoggingUtil.printError(e.getMessage());
				throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.FILE_SAVE_ERROR);
			}
		} else {
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.EMPTY_FILE_ERROR);
		}
	}
}
