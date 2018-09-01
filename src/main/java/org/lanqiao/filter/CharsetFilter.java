package org.lanqiao.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
//filterName = "CharsetFilter" ,urlPatterns = "/*"
public class CharsetFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //前驱操作(request)
        // 第一个过滤器的前驱-->第二个过滤器的前驱-->第三个过滤器的前驱-->servlet-->第三个过滤器的后继-->第二个过滤器的后继-->第一个过滤器的后继
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, resp);
        //后继操作(response)

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
