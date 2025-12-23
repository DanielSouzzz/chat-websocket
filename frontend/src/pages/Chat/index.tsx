import React, { useEffect, useState } from 'react';
import styles from './styles.module.css';

import { MessageList } from '../../components/MessageList';
import { MessageInput } from '../../components/MessageInput';

import { Message, User } from '../../types';
import { getMessages } from '../../services/messageService';

export const ChatPage: React.FC = () => {
  const [messages, setMessages] = useState<Message[]>([]);
  
  const currentUser: User = { id: 1, name: "Daniel", email: "eu@dev.com" };

  useEffect(() => {
    const loadData = async () => {
      const data = await getMessages();
      setMessages(data);
    };
    loadData();
  }, []);

  const handleSendMessage = (text: string) => {
    const newMessage: Message = {
      id: Date.now(), // Gera um ID único temporário baseada em timestamp
      text: text,
      sender: currentUser,
      receiver: { id: 2, name: "Cliente", email: "c@c.com" },
      createdAt: new Date().toISOString()
    };

    setMessages((prevMessages) => [...prevMessages, newMessage]);
    
  };

  return (
    <div className={styles.pageContainer}>
      {/* Cabeçalho simples */}
      <header className={styles.header}>
        <span>Chat Suporte</span>
      </header>

      {/* A Lista que só sabe exibir dados */}
      <MessageList 
        messages={messages} 
        currentUserId={currentUser.id} 
      />

      {/* O Input que avisa quando tem texto novo */}
      <MessageInput 
        onSendMessage={handleSendMessage} 
      />
    </div>
  );
};