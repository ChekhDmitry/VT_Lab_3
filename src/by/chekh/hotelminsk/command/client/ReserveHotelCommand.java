package by.chekh.hotelminsk.command.client;

import by.chekh.hotelminsk.bean.Request;
import by.chekh.hotelminsk.bean.User;
import by.chekh.hotelminsk.command.Command;
import by.chekh.hotelminsk.dao.HotelDAO;
import by.chekh.hotelminsk.dao.RequestDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by dima on 11/16/2017.
 */
public class ReserveHotelCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {


        Request requestEntity = new Request();
        int hotelId = Integer.parseInt(request.getParameter("hotelid"));
        int placesCount = Integer.parseInt(request.getParameter("reservedplacescount"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        requestEntity.setUserId(user.getId());
        requestEntity.setPlacesCount(placesCount);
        requestEntity.setHotelId(hotelId);

        try {
            RequestDAO.INSTANCE.createEntity(requestEntity);
            HotelDAO.INSTANCE.updatePlacesCount(requestEntity.getHotelId(),-requestEntity.getPlacesCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new ShowClientHotelsCommand().execute(request);
        return "/hotelsminsk";
    }
}
