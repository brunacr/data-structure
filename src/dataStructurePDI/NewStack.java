package dataStructurePDI;

/*Esse código implementa uma pilha (stack) usando uma lista encadeada (linked list) em Java.
A pilha é uma estrutura de dados que segue o princípio LIFO (Last In, First Out).
Este código fornece uma implementação básica de uma pilha utilizando uma lista encadeada,
com métodos para verificar se a pilha está vazia (isEmpty), acessar o valor no topo sem removê-lo (peek),
adicionar um valor ao topo (push) e remover e retornar o valor do topo (pop).*/

class Node { //Define a classe Node que representa um nó na pilha
    int data; //Campo que armazena o valor (dado) do nó
    Node next; //Campo que armazena a referência (ponteiro) para o próximo nó na lista
}
public class NewStack { //Define a classe NewStack que representa a pilha
    public Node top; //Um campo que armazena a referência para o nó do topo da pilha

    public boolean isEmpty() { //Método que verifica se a pilha está vazia
        return this.top == null; //Retorna true se o topo da pilha for null, indicando que a pilha está vazia
    }

    public Integer peek() { //Método que retorna o valor do nó no topo da pilha sem removê-lo
        if (top == null){ //Verifica se a pilha está vazia
            return null; //Retorna null se a pilha estiver vazia
        }
        return top.data; //Retorna o valor do nó no topo da pilha
    }

    public void push(int data){ //Método que adiciona um nó com o valor especificado ao topo da pilha
        Node node = new Node(); //Cria um novo nó
        node.data = data; //Define o valor do novo nó
         if(isEmpty()) { //Verifica se a pilha está vazia
             top = node; //Define o novo nó como o topo da pilha se ela estiver vazia
             return;
         }
         node.next = top; //Define o próximo nó do novo nó como o atual topo da pilha (atualiza o próximo com o valor que estava no topo)
         top = node; //Define o novo nó como o topo da pilha
    }

    public int pop(){ //Método que remove e retorna o valor do nó no topo da pilha
        int data = top.data; //Armazena o valor do nó que está no topo da pilha
        top = top.next; //Atualiza o topo da pilha para ser o próximo nó
        return data; //Retorna o valor do nó removido do topo da pilha
    }

    public void display() { //Método que exibe todos os elementos da pilha, indicando quais são o topo e o fundo (bottom)
        Node current = top; //Inicializa um ponteiro current para percorrer a pilha a partir do topo (top)

        while (current != null) { //Um loop while que percorre todos os nós da pilha até encontrar o final (null)
            String format = "\t[%3s  ]\n";
            if (current == top) { //Define uma string de formato para a impressão. Se o nó atual for o topo, adiciona "top" ao formato. Se for o último nó (bottom), adiciona "bottom" ao formato
                format = "\t[%3s  ] top\n";
            }
            if (current.next == null) {
                format = "\t[%3s  ] bottom\n";
            }
            System.out.printf(format, current.data); //Imprime os dados do nó atual usando o formato definido
            current = current.next; //Avança para o próximo nó na pilha
        }
    }

    public void displayUntil(int limit) { //Método que exibe os elementos da pilha até um limite especificado, indicando o topo e o fundo (bottom) quando apropriado
        Node current = top; //Inicializa um ponteiro current para percorrer a pilha a partir do topo e um contador count para controlar o número de nós exibidos
        int count = 1;

        while(count <= limit && current != null) {
            String format = "\t[%3s  ]\n";
            if (current == top) {
                format = "\t[%3s  ] top\n";
            }
            if (current.next == null) {
                format = "\t[%3s  ] bottom\n";
            }
            System.out.printf(format, current.data);
            current = current.next;
            count++;
        }
    }

    public void displayInvertedUntil(int limit) {
        NewStack auxStack = new NewStack(); //Cria uma nova pilha auxiliar
        Node current = top; //Inicializa a variável 'current' com o nó do topo da pilha original
        int count = 1; //Inicializa um contador para rastrear o número de nós processados

        while (current != null) {
            auxStack.push(current.data); //Empilha os dados do nó atual na pilha auxiliar
            current = current.next; //Move para o próximo nó na pilha original
        }

        current = auxStack.top; //Reposiciona 'current' para o topo da pilha auxiliar

        while (count <= limit && current != null) {
            String format = "\t[%3s  ]\n"; //Define o formato padrão da string para impressão
            if (current == auxStack.top) { //Se 'current' for o nó do topo da pilha auxiliar, altera o formato da string para indicar que é o topo
                format = "\t[%3s  ] top\n";
            }
            if (current.next == null) { //Se 'current.next' for nulo, altera o formato da string para indicar que é o final da pilha
                format = "\t[%3s  ] bottom\n";
            }
            System.out.printf(format, current.data); //Imprime os dados do nó atual no formato especificado
            current = current.next; //Move para o próximo nó na pilha auxiliar
            count++; //Incrementa o contador
        }
    }
}
