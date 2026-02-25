import { useEffect, useState, useRef } from "react";
import { Client } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import { Message } from '../models';

export function useChatSocket(chatId: string) {
    const [messages, setMessages] = useState<Message[]>([]);

    const stompClientRef = useRef<Client | null>(null);

    useEffect(() => {
        if (!chatId) return;

        const client = new Client({
            webSocketFactory: () => new SockJS('http://localhost:8080/chat-connect'),
            debug: (str) => console.log("STOPM: ", str),

            onConnect: () => {
                console.log('Conectado ao Servidor WebSocket!');

                client.subscribe('/app', (message) => {
                    const newMessages: Message = JSON.parse(message.body);

                    setMessages((prevMessages) => [...prevMessages, newMessages]);
                });
            },

            onStompError: (frame) => {
                console.error('Erro no STOMP: ', frame.headers['message']);
            },
        });

        client.activate();
        stompClientRef.current = client;

        return () => {
            if (client) {
                client.deactivate();
            }
        };
    }, [chatId]);

    const sendMessage = (text: string, senderId: string) => {
        if (stompClientRef.current && stompClientRef.current.connected) {
            stompClientRef.current.publish({
                destination: `/sendPrivateMessage`,
                body: JSON.stringify({ text, senderId }),
            });
        } else {
            console.error('WebSocket não está conectado!');
        }
    };

    return {
        messages,
        sendMessage
    };
}