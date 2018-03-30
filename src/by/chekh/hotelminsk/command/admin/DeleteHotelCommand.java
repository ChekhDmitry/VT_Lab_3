package by.chekh.hotelminsk.command.admin;

import by.chekh.hotelminsk.command.Command;
import by.chekh.hotelminsk.dao.HotelDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by dima on 11/22/2017.
 */
public class DeleteHotelCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        int hotelId = Integer.parseInt(request.getParameter("hotelid"));
        try {
            HotelDAO.INSTANCE.deleteEntity(hotelId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        new ShowAdminPageCommand().execute(request);
        return "/hotelsminsk";
    }
}
