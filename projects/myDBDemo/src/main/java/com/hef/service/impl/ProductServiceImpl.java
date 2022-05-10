package com.hef.service.impl;

import com.hef.conf.MyDBConf;
import com.hef.domain.ProductItem;
import com.hef.service.ProductService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2022/5/10
 * @Author lifei
 */
public class ProductServiceImpl implements ProductService {



    @Override
    public void insertProductItem(ProductItem productItem) {
        Connection con=null;
        PreparedStatement stat=null;
        try {
            // 第一步：加载数据库驱动
            Class.forName(MyDBConf.DRIVER);
            // 第二步：创建数据连接
            con = DriverManager.getConnection(MyDBConf.URL, MyDBConf.USERNAME, MyDBConf.PASSWORD);
            stat = con.prepareStatement("insert into druid_test_db.t_product_item(product_name, product_version) values (?, ?)");
            stat.setString(1, productItem.getProductName());
            stat.setString(2, productItem.getProductVersion());
            stat.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }finally {
                    stat=null;
                }
            }
            if (con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }finally {
                    con=null;
                }
            }
        }
    }

    @Override
    public List<ProductItem> findProductItemList() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            List<ProductItem> result = new ArrayList<>();
            Class.forName(MyDBConf.DRIVER);
            connection = DriverManager.getConnection(MyDBConf.URL, MyDBConf.USERNAME, MyDBConf.PASSWORD);
            statement = connection.prepareStatement("select pi_id,product_name,product_version from druid_test_db.t_product_item",
                    new String[]{"pi_id", "product_name", "product_version"});
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long piId = resultSet.getLong("pi_id");
                String productName = resultSet.getString("product_name");
                String productVersion = resultSet.getString("product_version");
                result.add(new ProductItem.Builder()
                        .piId(piId)
                        .productName(productName)
                        .productVersion(productVersion)
                        .builder());
            }
            return result;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }finally {
                    statement=null;
                }
            }
            if (resultSet!=null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }finally {
                    resultSet=null;
                }
            }
            if (connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }finally {
                    connection=null;
                }
            }
        }
    }

    @Override
    public void deleteProductItemById(Long piId) {
        Connection con=null;
        PreparedStatement stat=null;
        try {
            // 第一步：加载数据库驱动
            Class.forName(MyDBConf.DRIVER);
            // 第二步：创建数据连接
            con = DriverManager.getConnection(MyDBConf.URL, MyDBConf.USERNAME, MyDBConf.PASSWORD);
            stat = con.prepareStatement("delete from druid_test_db.t_product_item where pi_id=?");
            stat.setLong(1, piId);
            stat.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }finally {
                    stat=null;
                }
            }
            if (con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }finally {
                    con=null;
                }
            }
        }
    }

    @Override
    public void updateProductItem(ProductItem productItem) {
        Connection con=null;
        PreparedStatement stat=null;
        try {
            // 第一步：加载数据库驱动
            Class.forName(MyDBConf.DRIVER);
            // 第二步：创建数据连接
            con = DriverManager.getConnection(MyDBConf.URL, MyDBConf.USERNAME, MyDBConf.PASSWORD);
            stat = con.prepareStatement("update druid_test_db.t_product_item set product_name=?,product_version=? where pi_id=?");
            stat.setString(1, productItem.getProductName());
            stat.setString(2, productItem.getProductVersion());
            stat.setLong(3, productItem.getPiId());
            stat.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }finally {
                    stat=null;
                }
            }
            if (con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }finally {
                    con=null;
                }
            }
        }
    }
}
