import { Message, User } from '../types';

const currentUser: User = { id: 1, name: "Daniel", email: "eu@dev.com" };
const otherUser: User = { id: 2, name: "Cliente", email: "cliente@teste.com" };

const mockMessages: Message[] = [
  {
    id: 1,
    text: "Olá, preciso de ajuda com o sistema.",
    sender: otherUser,
    receiver: currentUser,
    createdAt: "2023-10-27T10:00:00"
  },
  {
    id: 2,
    text: "Claro! Qual o erro que está acontecendo?",
    sender: currentUser,
    receiver: otherUser,
    createdAt: "2023-10-27T10:01:00"
  }
];

export const getMessages = async (): Promise<Message[]> => {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve(mockMessages);
    }, 1000);
  });
};