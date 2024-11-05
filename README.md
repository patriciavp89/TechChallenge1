Arquitetura e Desenvolvimento Java
Tech Challenge FASE 1
Aluna: Patricia Villa Nova de Oliveira Pinho Teixeira

Contexto e Requisitos:
Este sistema vai complementar um sistema já existente de oportunidades de vendas, permitindo que, sempre que uma oportunidade tiver seu status atualizado para Falha, Cancelada ou Pausada, um motivo seja adicionado. Esse motivo pode ser utilizado para análises posteriores, como identificar as razões para o fechamento de oportunidades sem sucesso, medindo a perfomance do time técnico e comercial, e gerar insights sobre o processo de vendas. 
Evento de Entrada: Uma oportunidade com status alterado para Falha, Cancelada ou Pausada.
Ação: Inserir uma justificativa com o motivo da mudança de status.
Requisitos: 
•	Manter um registro da oportunidade e de seu motivo de fechamento.
•	Permitir a consulta do histórico de motivos das oportunidades fechadas.

Domínio: VENDAS
Contexto:
O sistema será responsável por gerenciar o motivo do status da oportunidade. Como o sistema de oportunidades já existe, nosso novo sistema irá interagir com ele para ler e atualizar informações. 
Subdomínio: Motivo de Fechamento 
Dentro do contexto de Oportunidades, teremos um subdominio para gerenciar o motivo de Fechamento.

Entidades:
Oportunidade
Descrição: Representa uma oportunidade de venda.

Atributos:
•	ID: Identificador único da oportunidade.
•	Vendedor: Nome do vendedor que atuou na oportunidade.
•	Cliente: Nome do cliente target da oportunidade.
•	DT Início: Data de início da oportunidade.
•	DT Fim: Data em que a oportunidade foi encerrada.
•	Valor Previsto: Valor previsto da oportunidade.
•	Descrição: Descrição da oportunidade
•	Status: Status atual da oportunidade (Falha, Pausado, Cancelado).

Motivo
Motivo associado ao fechamento (presente apenas para status Falha, Pausado ou Cancelado).
Descrição: Representa o motivo associado ao fechamento da oportunidade.

Atributos:
•	ID: Identificador único do motivo.
•	Motivo: Texto explicativo do motivo 
•	DataRegistro: Data e hora em que o motivo foi registrado.

Agregados:
•	Oportunidade (Agregado Principal)
A entidade Oportunidade contém informações básicas da oportunidade e o campo motivoFechamento, que armazena o motivo apenas quando o status é atualizado Falha, Pausado ou Cancelado.

Domínio:
StatusOportunidade
Descrição: Serviço responsável pela adição de motivo quando o status é atualizado para Falha, Pausado ou Cancelado.
Métodos:
alterarStatusOportunidade: 
Altera o status de uma oportunidade.
Regras de Negócio:
Quando novoStatus é Falha, Pausado ou Cancelado, o motivo é obrigatório e deve ser salvo junto à oportunidade.
Um evento StatusOportunidadeAlterado é emitido após a atualização do status.
Eventos de Domínio:
StatusOportunidadeAlterado
Descrição: Evento emitido quando o status de uma oportunidade é alterado para Falha, Pausado ou Cancelado.
Atributos:
•	oportunidadeId: Identificador da oportunidade alterada.
•	novoStatus: Novo status da oportunidade.
•	motivo: Motivo associado ao fechamento (quando aplicável).
•	data: Data e hora da alteração do status.
Este evento poderá ser utilizado para integração com outros serviços, como relatórios de vendas, geração de insights, data quality, avaliação de desempenho dos times técnicos e comercial ou mesmo notificações para a equipe de vendas.

Fluxo do Caso de Uso: Alteração de Status com Motivo
Um evento de alteração de status de uma oportunidade é acionado pelo sistema principal.
O StatusOportunidade recebe o evento e, ao verificar que o novo status é Falha, Pausado ou Cancelado, solicita ao usuário a justificativa do motivo.
O motivo é então registrado no MotivoFechamento e associado à oportunidade.
O serviço emite o evento StatusOportunidadeAlterado, que é capturado por outros sistemas externos.

Código:

NetOportunidades/src/main/java/frontend é o path para a tela desenvolvida
