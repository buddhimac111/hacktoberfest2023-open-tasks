package com.zuse.zuseGym.service;


import com.zuse.zuseGym.dto.PermissionDto;
import com.zuse.zuseGym.dto.ReschedulingDto;
import com.zuse.zuseGym.dto.RoleDto;
import com.zuse.zuseGym.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class AdminService {

    @Value("${zuse.roles}")
    private String roles;

    @Value("${zuse.permissions}")
    private String permissions;

    @Value("${datasource.url}")
    private String databaseUrl;

    @Value("${datasource.username}")
    private String databaseUsername;

    @Value("${datasource.password}")
    private String databasePassword;

    /**
     * get all the roles
     *
     * @return
     */
    public List<RoleDto> getRoles() {
        if (roles != null) {
            return this.getRolesInDB();
        } else {
            return null;
        }
    }

    /**
     * show proos
     **/
    public String displayPromo() {

        Connection con = null;
        Statement stmt = null;
        String promoStatus = null;
        //username string coming with single quotes that need to be removed

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT attributevalue FROM systemconfig WHERE attributename='showpromo';");

            if (rst.next()) {
                promoStatus = rst.getString(1);
            } else {
                System.out.println("No promo status found");
            }

            con.close();
            stmt.close();

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return promoStatus;

    }

    /**
     * // get all the System roles
     *
     * @param str
     * @return
     */
    public List<String> getSystemRoles(String str) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, ",");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }

    /**
     * get Permissions
     *
     * @return
     */
    public List<String> getPermissions() {
        if (permissions != null) {
            return this.getsystemPermissions(permissions);
        } else {
            return null;
        }
    }

    /**
     * get System Permissions
     *
     * @param stp
     * @return
     */
    public List<String> getsystemPermissions(String stp) {
        List<String> tokenss = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(stp, ",");
        while (tokenizer.hasMoreElements()) {
            tokenss.add(tokenizer.nextToken());
        }
        return tokenss;
    }


    /**
     * get all users in the Database
     *
     * @return
     */
    public List<String> getUsersInDB() {

        Connection con = null;
        Statement stmt = null;
        List<String> usernames = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shcart", "root", "");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);

            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery("select username from users  ;");
            while (rst.next()) {
                //    userid = rst.getInt(1);
                String username = rst.getString(1);

                usernames.add(username);

            }

            con.close();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return usernames;
    }

    /**
     * @param username
     * @return
     */
    public UserDto getUserDetails(String username) {

        Connection con = null;
        Statement stmt = null;
        List<String> userDetails = new ArrayList<>();
        UserDto userDto = new UserDto();
        //username string coming with single quotes that need to be removed
        String loggedUser = username.replaceAll("[']", "");
        ;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shcart", "root", "");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);

            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT first_name, last_name, mobile, email, username, created_at,id from users where username = '" + loggedUser + "';");

            if (rst.next()) {
                userDto.setFirstName(rst.getString(1));
                userDto.setLastName(rst.getString(2));
                userDto.setMobile(rst.getString(3));
                userDto.setEmail(rst.getString(4));
                userDto.setUsername(rst.getString(5));
                userDto.setCreatedAt(rst.getDate(6));
                userDto.setUserid(rst.getInt(7));
            } else {
                System.out.println("No user found");
            }

            con.close();
            stmt.close();

        } catch (Exception ex) {
            System.out.println("Error in getUserDetails");
            ex.printStackTrace();
        }

//        return userDetails;
        return userDto;

    }

    /**
     * get all the Roles in the Database
     *
     * @return
     */
    public List<RoleDto> getRolesInDB() {

        Connection con = null;
        Statement stmt = null;
        List<RoleDto> roles = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery("select id,name from roles;");
            while (rst.next()) {
                RoleDto role = new RoleDto();
                int roleId = rst.getInt(1);
                role.setId(roleId);
                role.setName(rst.getString(2));

                roles.add(role);
            }

            con.close();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return roles;
    }

    /**
     * get all trainers
     */
    public List<String> getAllTrainers() {

        Connection con = null;
        Statement stmt = null;
        List<String> trainers = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery(" select u.username from users as u where u.id in ( select user_id from user_roles where role_id = 5 or role_id = 6) ");
            while (rst.next()) {
                String username = rst.getString(1);

                trainers.add(username);
            }
            con.close();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return trainers;

    }

    /**
     * get User count
     */
    public int getUserCount() {
        Connection con = null;
        Statement stmt = null;
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT COUNT(id) AS count FROM users");
            if (rst.next()) {
                count = rst.getInt("count");
                ;

            }

            con.close();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return count;

    }

    /**
     * @return
     */
    public int getInquiryCount() {
        Connection con = null;
        Statement stmt = null;
        int incount = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT COUNT(id) AS count FROM book_inquiry");
            if (rst.next()) {
                incount = rst.getInt("count");
            }
            con.close();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return incount;
    }

    /**
     * @return
     */
    public int getCommonBlogCount() {
        Connection con = null;
        Statement stmt = null;
        int incount = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT COUNT(id) AS count FROM blogs");
            if (rst.next()) {
                incount = rst.getInt("count");
            }
            con.close();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return incount;
    }

    /**
     * @return
     */
    public int getPhysiotherapyBlogCount() {
        Connection con = null;
        Statement stmt = null;
        int incount = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT COUNT(id) AS count FROM physiotherapy_blogs");
            if (rst.next()) {
                incount = rst.getInt("count");
            }
            con.close();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return incount;

    }


    /**
     * @return
     */
    public int getRescheduleCount() {
        Connection con = null;
        Statement stmt = null;
        int incount = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT COUNT(request_id) AS count FROM trainer_rescheduling_timetable");
            if (rst.next()) {
                incount = rst.getInt("count");
            }
            con.close();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return incount;

    }

    /**
     * @return
     */
    public int getPromotionCount() {
        Connection con = null;
        Statement stmt = null;
        int incount = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery("SELECT COUNT(id) AS count FROM promotions");
            if (rst.next()) {
                incount = rst.getInt("count");
            }
            con.close();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return incount;
    }


    /**
     * get Role Id by Role Name
     */
    public int getRoleIdByRoleName(String roleName) {

        Connection con = null;
        Statement stmt = null;
        List<String> trainers = new ArrayList<>();
        int roleId = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery("select * from roles where name = '" + roleName + "' ;");
            if (rst.next()) {
                roleId = rst.getInt(1);
                ;

            }

            con.close();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return roleId;

    }


    /**
     * get all the Permissions in the Database
     *
     * @return
     */
    public List<PermissionDto> getPermissionsInDB() {

        Connection con = null;
        Statement stmt = null;
        List<PermissionDto> permissions = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery("select id,name from permissions;");
            while (rst.next()) {
                PermissionDto permission = new PermissionDto();
                int permissionId = rst.getInt(1);
                permission.setId(permissionId);
                permission.setName(rst.getString(2));

                permissions.add(permission);
            }

            con.close();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return permissions;
    }

    /**
     * get all the reschedule requests in the Database
     *
     * @return
     */

    public List<ReschedulingDto> getReschedulingRequest() {

        Connection con = null;
        Statement stmt = null;
        List<ReschedulingDto> rescheduleRequests = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            ResultSet rst = stmt.executeQuery("select request_id,username,requested_date,requested_time,status from trainer_rescheduling_timetable;");
            while (rst.next()) {
                ReschedulingDto rescheduleRequest = new ReschedulingDto();
                rescheduleRequest.setRequest_id(rst.getInt("request_id"));
                rescheduleRequest.setTrainer_username(rst.getString("username"));
                rescheduleRequest.setRequested_date(rst.getDate("requested_date"));
                rescheduleRequest.setRequested_time(rst.getTime("requested_time"));
                rescheduleRequest.setStatus(rst.getString("status"));
                rescheduleRequests.add(rescheduleRequest);
            }
            con.close();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rescheduleRequests;
    }

    /**
     * update Book requests status in the Database
     *
     * @return
     */
    public boolean updateBookRequests(int id, String status) {

        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            stmt.executeUpdate("update book_inquiry set status = '" + status + "' where id = " + id + ";");
            con.close();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }


    /**
     * update requests status in the Database
     *
     * @return
     */
    public boolean updateReschedulingRequest(int request_id, String status) {

        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            stmt.executeUpdate("update trainer_rescheduling_timetable set status = '" + status + "' where request_id = " + request_id + ";");
            con.close();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }

    public void addActivity(String Account, String activity, String description) {

        // Get the current date
        String currentDate = LocalDate.now().toString();

        // Get the current time
        String currentTime = LocalTime.now().toString();

        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            stmt.executeUpdate("insert into activity_log (account,activity,description,date,time) values ('" + Account + "','" + activity + "','" + description + "','" + currentDate + "','" + currentTime + "')");
            con.close();
            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public boolean addRoleService(int selectedUserIdAdd,int selectedRole,String description){

        Connection con = null;
        Statement stmt = null;
        boolean result = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
            stmt = con.createStatement();
            stmt.executeUpdate("insert into user_roles (user_id,role_id) values ('" + selectedUserIdAdd + "','" + selectedRole + "')");
            //add description
            stmt.executeUpdate("UPDATE users SET description = '" + description + "'  WHERE id = '" + selectedUserIdAdd + "';");
            result = true;

        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        }
        finally {
            try {
                con.close();
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
