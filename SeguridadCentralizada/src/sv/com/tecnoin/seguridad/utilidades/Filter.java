package sv.com.tecnoin.seguridad.utilidades;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sv.com.tecnoin.seguridad.entidad.Usuario;


/**
 * Servlet Filter implementation class LoginFilter
 */
public class Filter implements javax.servlet.Filter {

	/**
	 * Default constructor.
	 */
	public Filter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpSession session = (HttpSession) hrequest.getSession();
		Usuario usuario = (Usuario) session.getAttribute("USUARIO");

		String url = hrequest.getRequestURL().toString();

		if (usuario == null && !url.contains(".png") && !url.contains("/acciones/index")
				&& !url.contains("/bootstrap-3.3.5/") && !url.contains("/imgs/")) {
			hrequest.getRequestDispatcher("/index.jsp").forward(request, response);
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
