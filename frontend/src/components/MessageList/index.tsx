import React, { useEffect, useRef } from 'react';
import styles from './styles.module.css';
import { MessageBubble } from '../MessageBubble';
import { Message } from '../../types';

interface MessageListProps {
  messages: Message[];    
  currentUserId: number;
}

export const MessageList: React.FC<MessageListProps> = ({ messages, currentUserId }) => {
  const bottomRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    bottomRef.current?.scrollIntoView({ behavior: 'smooth' });
  }, [messages]);

  return (
    <div className={styles.listContainer}>
      {}
      {messages.map((msg) => (
        <MessageBubble 
          key={msg.id}
          message={msg} 
          isMine={msg.sender.id === currentUserId} 
        />
      ))}

      {}
      <div ref={bottomRef} />
    </div>
  );
};