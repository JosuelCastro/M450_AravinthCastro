import { Route, Routes } from "react-router-dom";
import LoginPage from "../components/pages/LoginPage/LoginPage";
import PrivateRoute from "./PrivateRoute";
import HomePage from "../components/pages/HomePage";
import Profile from "../components/pages/UserPage/UserProfile";
import UserTable from "../components/pages/UserPage/UserTable";
import UserPage from "../components/pages/UserPage/UserPage";
import RegisterPage from "../components/pages/RegisterPage/RegisterPage";
import Unauthorized from "./Unauthorized";
import Navbar from "../components/organisms/Navbar";

/**
 * Router component renders a route switch with all available pages
 */

const Router = () => {
  //const { checkRole } = useContext(ActiveUserContext);

  /** navigate to different "home"-locations depending on Role the user have */

  return (
    <Routes>
      <Route path={"/"} element={<PrivateRoute authorities={[]} element={<HomePage />} />} />
      <Route path={"/user/login"} element={<LoginPage />} />
        <Route path={"/register"} element={<RegisterPage />} />
      <Route
        path={"/users"}
        element={<PrivateRoute authorities={["ADMIN_READ"]} element={<UserTable />} />}
      />
        <Route
            path={"/useradd"}
            element={<PrivateRoute authorities={[]} element={<UserPage />} />}
        />
      <Route
        path="/userprofile"
        element={
          <PrivateRoute authorities={[]} element={<Profile />}></PrivateRoute>
        }
      />
      <Route
        path="/useredit/:userId"
        element={
          <PrivateRoute authorities={[]} element={<UserPage />}></PrivateRoute>
        }
      />
        <Route
            path='/unauthorized'
            element={
                <PrivateRoute authorities={[]} element={<Unauthorized />}></PrivateRoute>
            }
        />

      <Route path="*" element={<div>Not Found</div>} />
    </Routes>
  );
};

export default Router;
