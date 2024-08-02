# SDK em Java para API Integra Notas

Este SDK visa simplificar a integração do seu sistema com a nossa API, oferecendo classes com funções pré-definidas para acessar as rotas da API. Isso elimina a necessidade de desenvolver uma aplicação para se comunicar diretamente com a nossa API, tornando o processo mais eficiente e direto.

*Nota: Utilizamos a biblioteca request para fazer as requisições de nossa API.*

## Forma de instalação de nosso SDK:

Adicionar nas do arquivo do arquivo de configuração de depedencia maven pom.xml 

```
<dependency>
    <groupId>io.github.cloud-dfe</groupId>
    <artifactId>sdk-cloud-dfe</artifactId>
    <version>x.x.x</version>
</dependency>
```

## Forma de uso:

```java
package com.nomedopacote;

import io.github.sdk.Const;
import io.github.sdk.routes.Nfe;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Status {

    public static void main(String[] args) throws IllegalAccessException, IOException {

        try {

            int ambiente = Const.AMBIENTE_PRODUCAO;
            String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbXAiOiJ0b2tlbl9leGVtcGxvIiwidXNyIjoidGsiLCJ0cCI6InRrIn0.Tva_viCMCeG3nkRYmi_RcJ6BtSzui60kdzIsuq5X-sQ";
            int timeout = 60;

            Nfe nfe = new Nfe(ambiente, token, timeout, false);

            JsonObject resp = nfe.status();

            System.out.println(resp);

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}

```

### Sobre dados de envio e retornos

Para saber os detalhes referente ao dados de envio e os retornos consulte nossa documentação [IntegraNotas Documentação](https://integranotas.com.br/doc).

### Veja alguns exemplos de consumi de nossa API nos link abaixo:

[Pasta de Exemplos](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/)

[Utilitários](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/utils)

[Averbação](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/averbacao)

[Certificado Digital](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/certificado)

[CT-e](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/cte)

[CT-e OS](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/cteos)

[DF-e](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/dfe)

[Emitente](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/emitente)

[GNR-e](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/gnre)

[MDF-e](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/mdfe)

[NFC-e](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/nfce)

[NFCom](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/nfcom)

[NF-e](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/nfe)

[NFS-e](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/nfse)

[Softhouse](https://github.com/cloud-dfe/sdk-java/tree/master/examples/src/main/java/com/examples/softhouse)