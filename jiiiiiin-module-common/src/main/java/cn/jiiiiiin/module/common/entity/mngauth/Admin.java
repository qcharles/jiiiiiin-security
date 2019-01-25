package cn.jiiiiiin.module.common.entity.mngauth;

import cn.jiiiiiin.data.orm.entity.BaseEntity;
import cn.jiiiiiin.data.orm.util.View;
import cn.jiiiiiin.module.common.dto.mngauth.Menu;
import cn.jiiiiiin.module.common.enums.common.ChannelEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author jiiiiiin
 * @since 2018-09-27
 */
@ApiModel(value = "Admin对象", description = "用户表")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@TableName("mng_admin")
public class Admin extends BaseEntity<Admin> {

    private static final long serialVersionUID = -7474741970506921026L;
    @ApiModelProperty(value = "创建时间")
    @JsonIgnore
    private LocalDateTime createTime;

    @ApiModelProperty(value = "用户名")
    @JsonView(View.SimpleView.class)
    private String username;

    @ApiModelProperty(value = "密码，加密存储")
    @JsonView(View.SecurityView.class)
    private String password;

    @ApiModelProperty(value = "手机号")
    @JsonView(View.SimpleView.class)
    private String phone;

    @ApiModelProperty(value = "邮箱")
    @JsonView(View.SimpleView.class)
    private String email;

    @TableField(exist = false)
    @JsonView(View.DetailView.class)
    private Set<Role> roles = new HashSet<>();

    @ApiModelProperty(value = "标识渠道，不同的渠道就是不同的资源分组: 0:内管")
    @JsonView(View.DetailView.class)
    private ChannelEnum channel;

    @ApiModelProperty(value = "前端授权资源")
    @TableField(exist = false)
    private HashSet<Resource> authorizeResources;

    @ApiModelProperty(value = "前端菜单")
    @TableField(exist = false)
    private ArrayList<Menu> menus;

    public static final String CREATE_TIME = "create_time";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String PHONE = "phone";

    public static final String EMAIL = "email";

    public static final String CHANNEL = "channel";

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Admin)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Admin admin = (Admin) o;
        return Objects.equals(username, admin.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), username);
    }
}
