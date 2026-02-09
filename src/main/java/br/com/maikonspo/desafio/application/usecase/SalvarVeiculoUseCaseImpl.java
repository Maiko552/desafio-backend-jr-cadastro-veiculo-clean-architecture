package br.com.maikonspo.desafio.application.usecase;

import br.com.maikonspo.desafio.application.dto.CadastrarVeiculoCommand;
import br.com.maikonspo.desafio.domain.exception.CpfJaCadastradoException;
import br.com.maikonspo.desafio.domain.exception.DadosObrigatoriosException;
import br.com.maikonspo.desafio.domain.exception.PlacaJaCadastradaException;
import br.com.maikonspo.desafio.domain.gateway.VeiculoGateway;
import br.com.maikonspo.desafio.domain.gateway.VeiculoInfoGateway;
import br.com.maikonspo.desafio.domain.model.Veiculo;
import br.com.maikonspo.desafio.domain.model.valueobject.VeiculoInfo;
import br.com.maikonspo.desafio.domain.usecase.contract.SalvarVeiculoUsecase;
import org.springframework.stereotype.Service;

@Service
public class SalvarVeiculoUseCaseImpl
        implements SalvarVeiculoUsecase {

    private final VeiculoGateway veiculoGateway;
    private final VeiculoInfoGateway veiculoInfoGateway;

    public SalvarVeiculoUseCaseImpl(
            VeiculoGateway veiculoGateway,
            VeiculoInfoGateway veiculoInfoGateway
    ) {
        this.veiculoGateway = veiculoGateway;
        this.veiculoInfoGateway = veiculoInfoGateway;
    }

    @Override
    public Veiculo execute(CadastrarVeiculoCommand cmd) {

        if (cmd == null)
            throw new DadosObrigatoriosException();

        if (veiculoGateway.existsByPlaca(cmd.placa()))
            throw new PlacaJaCadastradaException(cmd.placa());

        if (veiculoGateway.existsByCpf(cmd.cpf()))
            throw new CpfJaCadastradoException(cmd.cpf());

        VeiculoInfo info = veiculoInfoGateway.obterPorPlaca(cmd.placa());

        Veiculo veiculo = new Veiculo(
                null,
                cmd.proprietario(),
                cmd.cpf(),
                cmd.placa(),
                info.chassi(),
                info.marca(),
                info.modelo(),
                info.licenciado()
        );

        return veiculoGateway.save(veiculo);
    }

}
