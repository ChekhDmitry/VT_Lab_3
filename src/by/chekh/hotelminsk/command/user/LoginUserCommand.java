package by.chekh.hotelminsk.command.user;

import by.chekh.hotelminsk.bean.User;
import by.chekh.hotelminsk.command.Command;
import by.chekh.hotelminsk.command.factory.CommandType;
import by.chekh.hotelminsk.command.util.LocalizationCommand;
import by.chekh.hotelminsk.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by dima on 11/16/2017.
 */
public class LoginUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String page = null;
        try{
            if(UserDAO.INSTANCE.isAuthorized(login,password)){
                HttpSession session = request.getSession();
                User user = UserDAO.INSTANCE.getUserByLogin(login);
                session.setAttribute("userType",user.getRole());
                session.setAttribute("user",user);

                if(user.getRole().equals("ROLE_CLIENT")){
                    CommandType type = CommandType.valueOf("SHOWCLIENTPAGE");
                    type.getCurrentCommand().execute(request);
                    page = "/jsp/client/main.jsp";
                }else{
                    CommandType type = CommandType.valueOf("SHOWADMINPAGE");
                    type.getCurrentCommand().execute(request);
                    page="/jsp/admin/main.jsp";
                }
            }else{
                page = "/index.jsp";
                if(login != null && password != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("errorLoginOrPassword", "Invalid login or password");
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
            page = "/index.jsp";
        }
        new LocalizationCommand().execute(request);
        return page;
    }
}
