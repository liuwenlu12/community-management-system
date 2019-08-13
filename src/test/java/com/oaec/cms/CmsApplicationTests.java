package com.oaec.cms;

import com.alibaba.fastjson.JSON;
import com.oaec.cms.entity.Admin;
import com.oaec.cms.mapper.AdminMapper;
import com.oaec.cms.mapper.PermissionMapper;
import com.oaec.cms.mapper.RoleMapper;
import com.oaec.cms.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsApplicationTests {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Test
    public void contextLoads() {
        /*Map<String, Object> param = new HashMap<>();
        param.put("adminId",4012);
        List<Permission> permissions = testMapper.queryPermissionLevle1(param);
        System.out.println(JSON.toJSONString(permissions));
*/
        Admin aSuper = adminMapper.queryByName("super");
        System.out.println(JSON.toJSONString(aSuper));

    }

}
