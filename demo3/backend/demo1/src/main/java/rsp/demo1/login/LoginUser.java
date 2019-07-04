package rsp.demo1.login;

import javax.validation.constraints.NotNull;

public class LoginUser {
    @NotNull(message = "用户名不允许为空")
    private String email;

    @NotNull(message = "密码不允许为空")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
