package by.chekh.hotelminsk.command.user;

import by.chekh.hotelminsk.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by dima on 11/16/2017.
 */
public class LogoutUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("userType");
        session.removeAttribute("errorLoginOrPassword");
        return "/hotelsminsk";
    }
}
