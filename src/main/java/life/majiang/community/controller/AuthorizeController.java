package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 点击登录后，即会回调我们的url地址，地址栏中携带code，需要进行解析
 * 根据请求回来的code和state以及app的其他参数进行封装，封装到自定义的accessTokenDTO类中
 * 调用第三方okhttp来获取token
 * 再使用https://api.github.com/user?access_token=加token的方式请求github获取用户信息，返回的是JSON字符串
 * 将JSON字符串通过FASTJSON转换成用户类返回
 */
@Controller
public class AuthorizeController {
    
    @Autowired
    private GithubProvider githubProvider;

    //@Value：在配置文件中读取key为github.client.id的value
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.client.uri}")
    private String redirect;
    
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,@RequestParam(name="state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
