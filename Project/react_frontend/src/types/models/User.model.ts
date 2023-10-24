import { Role } from './Role.model';
import {UserProfile} from "./UserProfile.model";

export type User = {
  id?: string;
  username: string;
  profile: UserProfile;
  email: string;
  password: string;
  roles: Role[];
};
