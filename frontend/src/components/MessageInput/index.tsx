import React, { useState, KeyboardEvent } from 'react';
import styles from './styles.module.css';

interface MessageInputProps {
  onSendMessage: (text: string) => void; 
}

export const MessageInput: React.FC<MessageInputProps> = ({ onSendMessage }) => {
  const [inputValue, setInputValue] = useState('');

  const handleSendClick = () => {
    if (inputValue.trim()) {
      onSendMessage(inputValue);
      setInputValue('');
    }
  };

  const handleKeyDown = (e: KeyboardEvent<HTMLInputElement>) => {
    if (e.key === 'Enter') {
      handleSendClick();
    }
  };

  return (
    <div className={styles.inputContainer}>
      <input
        type="text"
        className={styles.textInput}
        placeholder="Digite uma mensagem..."
        
        value={inputValue} 
        onChange={(e) => setInputValue(e.target.value)}
        
        onKeyDown={handleKeyDown}
      />
      
      <button 
        className={styles.sendButton} 
        onClick={handleSendClick}
        disabled={inputValue.trim().length === 0}
      >
        Enviar
      </button>
    </div>
  );
};