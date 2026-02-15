# Architectural Decisions

Este documento registra decisões técnicas do projeto.

---

## ADR-001 - Uso de DDD

### Decisão

Adotar princípios de Domain-Driven Design para modelagem do sistema.

### Motivação

Separar claramente regras de negócio de detalhes de infraestrutura.

### Consequência

Maior organização e facilidade de evolução futura.

---

## ADR-002 - Uso de Value Objects imutáveis

### Decisão

Representar conceitos como Money e Email como objetos imutáveis

### Motivação

Evitar estados inválidos e melhorar consistência do domínio.

### Consequência

Maior segurança e previsibilidade do sistema.

---

## ADR-003 - Repositórios como interfaces no domínio

### Decisão

Definir contratos de persistência no domínio e implementações na infraestrutura.

### Motivação

Permitir múltiplas estratégias de armazenamento (InMemory, JPA, etc).

### Consequência

Flexibilidade e testabilidade.

---

## ADR-004 - Uso de Enum para o status do pagamento ao invés de State Pattern

### Decisão

Usar um enum `PaymentStatus` dentro do agregado `Payment` ao invés de múltiplas classes implementando `PaymentState`.

### Motivação

O ciclo de vida do pagamento é simples e não possui comportamentos específicos por estado que justifiquem a complexidade do State Pattern.

### Consequência

Código mais simples, com menos classes e manutenção mais direta das regras de transição. Caso a lógica de cada estado evolua, o padrão State poderá ser reavaliado.
