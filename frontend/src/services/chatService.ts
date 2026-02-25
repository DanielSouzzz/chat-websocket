import { api } from './api';
import {User, Chat, Message } from '../models';

export const chatService = {
    createUser: async (username: string, email: string): Promise<User> => {
        const response = await api.post<User>('/users', { name: username, email: email});
        return response.data;
    },

    createChat: async (userId: string) => {
        const response = await api.post<Chat>('/chats', { participantId: userId });
        return response.data;
    },
}