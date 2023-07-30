package com.atstudy;

import com.atstudy.mapper.*;
import com.atstudy.pojo.*;
import com.atstudy.pojo.bo.*;
import com.atstudy.pojo.vo.PermissionRoleVo;
import com.atstudy.service.AdminService;
import com.atstudy.service.PermissionService;
import com.atstudy.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;
import java.awt.event.WindowFocusListener;
import java.util.List;

@SpringBootTest
@Slf4j
public class TestApplication {

    @Resource
    private AdminService adminService;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    @Resource
    private PermissionRoleVoMapper permissionRoleVoMapper;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private CartMapper cartMapper;

    @Resource
    private UserFavoriteMapper userFavoriteMapper;

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private BrandMapper brandMapper;

    @Resource
    private SpuAttrValueMapper spuAttrValueMapper;

    @Resource
    private SpuAttrKeyMapper spuAttrKeyMapper;

    @Resource
    private SpuAttrKeyCategoriesMapper spuAttrKeyCategoriesMapper;

    @Resource
    private SpuMapper spuMapper;

    @Resource
    private SkuMapper skuMapper;

    @Test
    public void testSku(){
//        Long aLong = skuMapper.countBySearchBo(new SkuSearchBo());
//        System.out.println("Sku的总数据量为===================>"+aLong);
        List<Sku> skuList = skuMapper.listBySearchBo(new SkuSearchBo(), new PageBo());
        for (Sku sku : skuList) {
            System.out.println(sku);
        }
    }

    @Test
    public void testSpuMapper(){
//        Long aLong = spuMapper.countBySearchBo(new SpuSearchBo());
//        System.out.println("总查询数=======================>"+aLong);
        List<Spu> spuList = spuMapper.listBySearchBo(new SpuSearchBo(), new PageBo());
        for (Spu spu : spuList) {
            System.out.println(spu);
        }
    }

    @Test
    public void testKeyMapper(){
//        int i = spuAttrKeyMapper.countByBo(new SpuAttrKeySearchBo());
//        System.out.println("spuAttrKeyMapper=======================>"+i);
//        List<SpuAttrKey> spuAttrKeys = spuAttrKeyMapper.listByBo(new SpuAttrKeySearchBo(), new PageBo());
//        for (SpuAttrKey spuAttrKey : spuAttrKeys) {
//            log.info(String.valueOf(spuAttrKey));
//        }
//        SpuAttrKey attrKey = spuAttrKeyMapper.listById("020f4f46-f4fc-4d1e-860c-f74b94fdc9a6");
//        System.out.println(attrKey);

        List<Integer> integerList = spuAttrKeyCategoriesMapper.listCateIdByKeyId("020f4f46-f4fc-4d1e-860c-f74b94fdc9a6");
        for (Integer integer : integerList) {
            System.out.println(integer);
        }
    }

    @Test
    public void textValueMapper(){
        List<SpuAttrValue> spuAttrValues = spuAttrValueMapper.listByKeyId("14431073323039259202052225656656188854");
        for (SpuAttrValue spuAttrValue : spuAttrValues) {
            System.out.println(spuAttrValue);
        }
    }

    @Test
    public void testBrand(){
        int i = brandMapper.countByBo(new BrandSearchBo());
        System.out.println(i);
        List<Brand> brands = brandMapper.listByBo(new BrandSearchBo(), new PageBo());
        for (Brand brand : brands) {
            log.info(String.valueOf(brand));
        }
    }

    @Test
    public void testCategory(){
//        List<Category> list = categoryMapper.list();
//        for (Category category : list) {
//            log.info(String.valueOf(category));
//        }
//        long l = categoryMapper.countByCategoryBo(new CategoryBo());
//        System.out.println("============================================"+l);

//        Category category = categoryMapper.selectByCateId(20);
//        log.info(String.valueOf(category));

        List<Category> categories = categoryMapper.listByCategoryBo(new CategoryBo(), new PageBo());
        log.info(String.valueOf(categories));
    }

    @Test
    public void testUserFavorite(){
        Long aLong = userFavoriteMapper.countByBo(new UserFavoriteBo());
        System.out.println("收藏数量为================================》"+aLong);
        List<UserFavorite> userFavorites = userFavoriteMapper.listByBo(new UserFavoriteBo(), new PageBo());
        for (UserFavorite userFavorite : userFavorites) {
            log.info(String.valueOf(userFavorite));
        }
    }

    @Test
    public void testCart(){
        Long aLong = cartMapper.countByCartBo(new CartBo());
        System.out.println("预购数为=======================》"+aLong);
        List<Cart> carts = cartMapper.listByCartBo(new CartBo(), new PageBo());
        for (Cart cart : carts) {
            log.info(String.valueOf(cart));
        }
    }

    @Test
    public void testOrder(){
        List<Order> orderList = orderMapper.listByByOrderBo(new OrderBo(), new PageBo());
        for (Order order : orderList) {
            log.info(String.valueOf(order));
        }
        Long aLong = orderMapper.countSelectByOrderBo(new OrderBo());
        System.out.println("总记录数为=======================>"+aLong);
    }

    @Test
    public void testRoleVo(){
        List<PermissionRoleVo> permissionRoleVos = permissionRoleVoMapper.selectPerRoleVo(15);
        for (PermissionRoleVo permissionRoleVo : permissionRoleVos) {
            log.info(String.valueOf(permissionRoleVo));
        }
    }

    @Test
    public void testRoleMapper(){
        Long count = roleMapper.selectCount(new QueryWrapper<>());
        log.info(String.valueOf(count));
    }

    @Test
    public void testPermission(){
        List<Permission> permissions = permissionService.listPermission();
        for (Permission permission : permissions) {
            log.info(permission.toString());
        }
    }

    @Test
    public void testRoleService(){
        for (Role role : roleService.listAll()) {
            System.out.println(role);
        }

    }

    @Test
    public void testAdminMapper(){
//        for (Admin admin : adminMapper.listByAdminBo(new AdminSearchBo(), new PageBo())) {
//            System.out.println(admin);
//        }
//        Long result = adminMapper.findResultCountByAdminSearchBo(new AdminSearchBo());
//        System.out.println(result);
        Admin admin = adminMapper.findByAdminId(1);
        System.out.println(admin);
    }

    @Test
    public void testMenu(){
        for (Menu menu : menuMapper.listMenuByAdminId(1)) {
            System.out.println(menu);
        }

    }

    @Test
    public void testAdmin(){
        UserDetails admin = adminService.loadUserByUsername("admin");
    }

    @Test
    public void testRole(){
        for (Role role : roleMapper.listByUrl("/admin/admin")) {
            System.out.println(role);
        }
    }
}
