import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class AsciiArtGenerator {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter image path: ");
            String imagePath = scanner.nextLine();

            BufferedImage image = ImageIO.read(new File(imagePath));

            String asciiArt = convertToAscii(image, 200);

            System.out.print("Choose output type (1=Console, 2=Text File, 3=JPG Image): ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {

                // Console
                System.out.println(asciiArt);

            } else if (choice == 2) {

                // Text File
                System.out.print("Enter output file name (without extension): ");
                String outputFile = scanner.nextLine();
                saveToFile(asciiArt, outputFile + ".txt");
                System.out.println("Saved as " + outputFile + ".txt");

            } else if (choice == 3) {

                // JPG Image
                System.out.print("Enter output image name (without extension): ");
                String outputFile = scanner.nextLine();
                saveAsImage(asciiArt, outputFile);
                System.out.println("Saved as " + outputFile + ".jpg");

            } else {
                System.out.println("Invalid choice.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String convertToAscii(BufferedImage image, int newWidth) {

        int originalWidth = image.getWidth();
        int originalHeight = image.getHeight();

        double aspectRatio = (double) originalHeight / originalWidth;
        int newHeight = (int) (newWidth * aspectRatio * 0.55);

        BufferedImage resized = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resized.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.drawImage(image, 0, 0, newWidth, newHeight, null);
        g.dispose();

        String ascii = "@#&$%QWNM0B8D6KHXEPZbqwmOCLJYUzcvunxrjft/|()1{}[]?-_+~<>i!lI;:,\"^`'. ";

        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < newHeight; y++) {
            for (int x = 0; x < newWidth; x++) {

                int rgb = resized.getRGB(x, y);

                int r = (rgb >> 16) & 0xff;
                int gVal = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;

                int gray = (int)(0.299*r + 0.587*gVal + 0.114*b);

                // Contrast boost
                gray = (gray - 128) * 2 + 128;
                gray = Math.max(0, Math.min(255, gray));

                int index = gray * (ascii.length() - 1) / 255;

                sb.append(ascii.charAt(index));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private static void saveToFile(String content, String fileName) throws IOException {

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(fileName), "UTF-8"));

        writer.write(content);
        writer.close();
    }

    private static void saveAsImage(String asciiArt, String fileName) throws IOException {

        String[] lines = asciiArt.split("\n");

        int fontSize = 12;
        int charWidth = 7;
        int charHeight = 12;

        int width = lines[0].length() * charWidth;
        int height = lines.length * charHeight;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = image.createGraphics();

        // Background black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        // White text
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN, fontSize));

        for (int i = 0; i < lines.length; i++) {
            g.drawString(lines[i], 0, (i + 1) * charHeight);
        }

        g.dispose();

        ImageIO.write(image, "jpg", new File(fileName + ".jpg"));
    }

}
