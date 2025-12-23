import React from 'react';
import styles from './styles.module.css'; 
import { Message } from '../../types';

interface MessageBubbleProps {
  message: Message;
  isMine: boolean;
}

export const MessageBubble: React.FC<MessageBubbleProps> = ({ message, isMine }) => {
  
  const bubbleClass = isMine ? styles.mine : styles.theirs;

  const formatTime = (dateString: string) => {
    const date = new Date(dateString);
    return date.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
  };

  return (
    <div className={`${styles.container} ${bubbleClass}`}>
      
      {/* Renderização Condicional: Só mostra nome se NÃO for eu */}
      {!isMine && (
        <span className={styles.senderName}>
          {message.sender.name}
        </span>
      )}

      <div className={styles.content}>
        {message.text}
      </div>

      <span className={styles.timestamp}>
        {formatTime(message.createdAt)}
      </span>
    </div>
  );
};