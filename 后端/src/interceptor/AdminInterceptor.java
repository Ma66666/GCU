package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pojo.UserInfo;
public class AdminInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception{
		
		HttpSession session=request.getSession();
		Object obj = session.getAttribute("user");
		System.out.println(String.format("AdminInterceptor preHandle ����ִ��, %s", obj));
		if (obj==null) {
			request.setAttribute("tips", "���¼");
			request.getRequestDispatcher("/error").forward(request, response);
			return false;
		}
		if(((UserInfo)obj).getRole()!=1) {
			request.setAttribute("tips", "��ʹ�ù���Ա�˺�");
			request.getRequestDispatcher("/error").forward(request, response);
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView)throws Exception{
	
		System.out.println("AdminInterceptor postHandle ����ִ��");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception{
		System.out.println("AdminInterceptor afterCompletion ����ִ��");
	}
}
