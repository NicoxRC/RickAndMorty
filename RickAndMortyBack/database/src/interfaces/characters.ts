import type { Types } from 'mongoose';

export interface charactersInterface {
  _id: number;
  name: string;
  status: string;
  species: string;
  type: string;
  gender: string;
  image: string;
  origin: Types.ObjectId;
  location: Types.ObjectId;
  epidose: Types.ObjectId[];
}
