import api from '../config/Api';
import { User } from '../types/models/User.model';

const UserService = {
  getUser: async (userID: string | undefined): Promise<User> => {
    try {
      const response = await api.get<User>(`/user/${userID}`);
      return response.data;
    } catch (error) {
      throw error; // Handle the error in your component
    }
  },

  updateUser: async (user: { profile: { } }): Promise<User> => {
    try {
      // @ts-ignore
      const response = await api.put<User>(`/user/${user.id}`, user);
      return response.data;
    } catch (error) {
      throw error; // Handle the error in your component
    }
  },

  getUserByID: async (userID: string | undefined): Promise<User | null> => {
    try {
      const response = await api.get<User>(`/user/${userID}`);
      return response.data;
    } catch (error) {
      throw error; // Handle other errors in your component
    }
  },

  addUser: async (user: User): Promise<User> => {
    try {
      const response = await api.post<User>('/user/registerUser', user);
      return response.data;
    } catch (error) {
      throw error; // Handle the error in your component
    }
  },

  getAllUsers: async (page: number, amount: number): Promise<User[]> => {
    try {
      const response = await api.get<User[]>('/user', {
        params: {
          page: page,
          amount: amount,
        },
      });
      return response.data;
    } catch (error) {
      throw error; // Handle the error in your component
    }
  },

  registerUser: async (user: User): Promise<User> => {
    try {
      const response = await api.post<User>('/user/register', user);
      return response.data;
    } catch (error) {
      throw error; // Handle the error in your component
    }
  },


  deleteUser: async (id: string | undefined): Promise<void> => {
    try {
      await api.delete(`/user/${id}`);
    } catch (error) {
      throw error; // Handle the error in your component
    }
  },
};

export default UserService;
