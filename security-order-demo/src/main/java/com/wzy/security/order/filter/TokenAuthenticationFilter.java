package com.wzy.security.order.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wzy.security.order.common.EncryptUtil;
import com.wzy.security.order.model.UserDTO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("json-token");
        if (token != null) {
            String json = EncryptUtil.decodeUTF8StringBase64(token);
            //将token转成json对象
            JSONObject jsonObject = JSON.parseObject(json);
            //用户身份信息
//            UserDTO userDTO = new UserDTO();
//            String principal = jsonObject.getString("principal");
//            userDTO.setUsername(principal);
            UserDTO userDTO = JSON.parseObject(jsonObject.getString("principal"), UserDTO.class);
            //用户权限
            JSONArray authoritiesArray = jsonObject.getJSONArray("authorities");
            String[] authorities = authoritiesArray.toArray(new String[authoritiesArray.size()]);
            //将用户信息和权限填充 到用户身份token对象中
            UsernamePasswordAuthenticationToken authenticationToken
                    = new UsernamePasswordAuthenticationToken(userDTO, null, AuthorityUtils.createAuthorityList(authorities));
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            //将authenticationToken填充到安全上下文
            //之后就会和安全上下文的Token进行比对
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}
