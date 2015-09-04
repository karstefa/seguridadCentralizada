package sv.com.tecnoin.seguridad.utilidades;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.captcha.Captcha;
import nl.captcha.noise.CurvedLineNoiseProducer;
import nl.captcha.backgrounds.FlatColorBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.servlet.SimpleCaptchaServlet;
import nl.captcha.text.producer.DefaultTextProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;


public class GeneraCaptcha extends SimpleCaptchaServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<java.awt.Color> textColors = Arrays.asList(Color.BLACK, Color.WHITE, Color.GREEN);
		List<java.awt.Font> textFonts = Arrays.asList(new Font("Arial", Font.BOLD, 40), new Font("Courier", Font.BOLD, 40));

		java.awt.Color backgroundColor = Color.GRAY;

		Captcha captcha = new Captcha.Builder(300, 50)
				.addText(new DefaultTextProducer(), new DefaultWordRenderer(textColors, textFonts)).gimp()
				.addBackground(new FlatColorBackgroundProducer(backgroundColor))
				.addNoise(new CurvedLineNoiseProducer(Color.YELLOW, 1)).build();

		CaptchaServletUtil.writeImage(response, captcha.getImage());

		request.getSession().setAttribute(Captcha.NAME, captcha);
	}
}