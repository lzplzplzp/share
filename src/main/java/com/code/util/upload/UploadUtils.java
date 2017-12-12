package com.code.util.upload;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.code.common.Constants;
import com.code.util.DateUtils;
import com.code.util.image.ImageUtils;




public class UploadUtils {
 
	private static Set<String> squeezedSet = null;
	
	static{
		squeezedSet = new HashSet<String>();
		squeezedSet.add("zip");
		squeezedSet.add("rar");
		squeezedSet.add("7z");
		squeezedSet.add("tar");
		squeezedSet.add("gzip");
		squeezedSet.add("bz2");
		squeezedSet.add("tar.gz");
	}
	
	private static Logger log = LoggerFactory.getLogger(UploadUtils.class);
	
	/**
	 * Upload日期格式化
	 */
	private static final String MONTH_FORMAT = "/yyyyMM/ddHHmmss";

	
	
	


	
	
	/**
	 * 通过扩展名和指定根目录生成文件目录和名字
	 * @param path
	 * @param userId 用户ID
	 * @param ext  后缀
	 * @return
	 */
	public static String generateFilename(String path, Integer userId,
			String ext) {
		return path + DateUtils.safeFormatTime(new Date(), MONTH_FORMAT) + "_"
				+ userId + "." + ext;
	}
 

	protected static final Pattern ILLEGAL_CURRENT_FOLDER_PATTERN = Pattern
			.compile("^[^/]|[^/]$|/\\.{1,2}|\\\\|\\||:|\\?|\\*|\"|<|>|\\p{Cntrl}");

	/**
	 * Sanitizes a filename from certain chars.<br />
	 * 
	 * This method enforces the <code>forceSingleExtension</code> property and
	 * then replaces all occurrences of \, /, |, :, ?, *, &quot;, &lt;, &gt;,
	 * control chars by _ (underscore).
	 * 
	 * @param filename
	 *            a potentially 'malicious' filename
	 * @return sanitized filename
	 */
	public static String sanitizeFileName(final String filename) {

		if (StringUtils.isBlank(filename))
			return filename;

		String name = forceSingleExtension(filename);

		// Remove \ / | : ? * " < > 'Control Chars' with _
		return name.replaceAll("\\\\|/|\\||:|\\?|\\*|\"|<|>|\\p{Cntrl}", "_");
	}

	/**
	 * Sanitizes a folder name from certain chars.<br />
	 * 
	 * This method replaces all occurrences of \, /, |, :, ?, *, &quot;, &lt;,
	 * &gt;, control chars by _ (underscore).
	 * 
	 * @param folderName
	 *            a potentially 'malicious' folder name
	 * @return sanitized folder name
	 */
	public static String sanitizeFolderName(final String folderName) {

		if (StringUtils.isBlank(folderName))
			return folderName;

		// Remove . \ / | : ? * " < > 'Control Chars' with _
		return folderName.replaceAll(
				"\\.|\\\\|/|\\||:|\\?|\\*|\"|<|>|\\p{Cntrl}", "_");
	}

	/**
	 * Checks whether a path complies with the FCKeditor File Browser <a href="http://docs.fckeditor.net/FCKeditor_2.x/Developers_Guide/Server_Side_Integration#File_Browser_Requests"
	 * target="_blank">rules</a>.
	 * 
	 * @param path
	 *            a potentially 'malicious' path
	 * @return <code>true</code> if path complies with the rules, else
	 *         <code>false</code>
	 */
	public static boolean isValidPath(final String path) {
		if (StringUtils.isBlank(path))
			return false;

		if (ILLEGAL_CURRENT_FOLDER_PATTERN.matcher(path).find())
			return false;

		return true;
	}

	/**
	 * Replaces all dots in a filename with underscores except the last one.
	 * 
	 * @param filename
	 *            filename to sanitize
	 * @return string with a single dot only
	 */
	public static String forceSingleExtension(final String filename) {
		return filename.replaceAll("\\.(?![^.]+$)", "_");
	}

	/**
	 * Checks if a filename contains more than one dot.
	 * 
	 * @param filename
	 *            filename to check
	 * @return <code>true</code> if filename contains severals dots, else
	 *         <code>false</code>
	 */
	public static boolean isSingleExtension(final String filename) {
		return filename.matches("[^\\.]+\\.[^\\.]+");
	}

	/**
	 * Checks a directory for existence and creates it if non-existent.
	 * 
	 * @param dir
	 *            directory to check/create
	 */
	public static void checkDirAndCreate(File dir) {
		if (!dir.exists())
			dir.mkdirs();
	}

	/**
	 * Iterates over a base name and returns the first non-existent file.<br />
	 * This method extracts a file's base name, iterates over it until the first
	 * non-existent appearance with <code>basename(n).ext</code>. Where n is a
	 * positive integer starting from one.
	 * 
	 * @param file
	 *            base file
	 * @return first non-existent file
	 */
	public static File getUniqueFile(final File file) {
		if (!file.exists())
			return file;

		File tmpFile = new File(file.getAbsolutePath());
		File parentDir = tmpFile.getParentFile();
		int count = 1;
		String extension = FilenameUtils.getExtension(tmpFile.getName());
		String baseName = FilenameUtils.getBaseName(tmpFile.getName());
		do {
			tmpFile = new File(parentDir, baseName + "(" + count++ + ")."
					+ extension);
		} while (tmpFile.exists());
		return tmpFile;
	}
	
	/**
	 * 检查图片格式等如果不正确返回失败页面
	 * @param file
	 * @param model
	 * @param extFilename 文件后缀
	 * @param errorUrl
	 * @return
	 */
	public static String chickPic(MultipartFile file, ModelMap model, String extFilename,String errorUrl) {
		if (file == null) {
			model.put(Constants.hint, "请选择文件");
			return errorUrl ;
		}
		if (StringUtils.isBlank(extFilename)) {
			model.put(Constants.hint, "没有图片后缀");
			return errorUrl ;
		}
		if (!ImageUtils.isValidImageExt(extFilename)) {
			model.put(Constants.hint, "只支持jpg, jpeg,gif,png,bmp格式图片");
			return errorUrl ;
		}
//		try {
//			if (!ImageUtils.isImage(file.getInputStream())) {
//				model.put(Constants.hint, "只支持jpg, jpeg,gif,png,bmp格式图片");
//				return errorUrl ;
//			}
//		} catch (IOException e) {
//			log.error("image upload error", e);
//			model.put(Constants.hint, "系统出错，请稍后在试");
//			return errorUrl ;
//		}
		return null ;
	}
	

	public static void main(String[] args) {
		System.out.println(DateUtils.safeFormatTime(new Date(), MONTH_FORMAT));
		System.out.println(generateFilename("/base",123, "gif"));
	}

	public static boolean checkSqueezed(String ext) {
		if(squeezedSet.contains(ext)){
			return true;
		}
		return false;
	}

	public static String getFilename(String path, Integer userId, String ext) {
		return path + userId+ File.separator +new Date().getTime() 
			+"_"+userId + "." + ext;
	}

}
