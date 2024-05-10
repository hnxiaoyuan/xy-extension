package org.example.extension.controller.request;

import org.example.extension.configuration.ParameterBinding;
import org.example.extension.configuration.SupportsCustomizedBinding;

import java.beans.ConstructorProperties;

/**
 * ParamDto
 *
 * @author dm-ai
 * @date 2023/5/17
 */
public class ParamDto extends ParentObject {
    @ParameterBinding("user_name")
    private String userName;
    private String passWd;

    // @ConstructorProperties({"1user_name", "1passwd"})
    public ParamDto(String userName, String passWd) {
        this.userName = userName;
        this.passWd = passWd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }
}
