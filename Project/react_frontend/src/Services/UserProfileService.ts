import api from '../config/Api';
import { User } from '../types/models/User.model';
import { UserProfile } from "../types/models/UserProfile.model";


const UserProfileService = {
    getProfile: async (): Promise<UserProfile> => {
        try {
            const response = await api.get<UserProfile>('/userprofile');
            return response.data;
        } catch (error) {
            throw error; // Handle the error in your component
        }
    },

    updateProfile: async (profile: UserProfile): Promise<UserProfile> => {
        try {
            const response = await api.put<UserProfile>('/userprofile', profile);
            return response.data;
        } catch (error) {
            throw error; // Handle the error in your component
        }
    },
};

export default UserProfileService;