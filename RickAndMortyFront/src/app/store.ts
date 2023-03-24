import { configureStore } from '@reduxjs/toolkit';
import characterReducer from '../slices/characterSlice';
import paginationReducer from '../slices/paginationSlice';

export const store = configureStore({
  reducer: {
    characters: characterReducer,
    pagination: paginationReducer,
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
