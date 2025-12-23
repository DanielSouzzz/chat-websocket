export interface User {
  id: number;
  name: string;
  email: string;
}

export interface Message {
  id: number;
  text: string;
  createdAt: string;

  sender: User;
  receiver: User;

  chatId?: string;
}