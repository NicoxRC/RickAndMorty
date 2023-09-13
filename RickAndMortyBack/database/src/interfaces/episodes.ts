import type { Document, Types } from 'mongoose';

export interface EpisodesInterface extends Document {
  _id: number;
  name: string;
  air_date: string;
  episode: string;
  characters: Types.ObjectId[];
}
