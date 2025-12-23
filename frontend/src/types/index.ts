export interface User {
  id: string;
  name: string;
  email: string;
}

export interface Message {
  id: string;
  text: string;
  createdAt: string;

  sender: User;
  receiver: User;

  chatId?: string;
}