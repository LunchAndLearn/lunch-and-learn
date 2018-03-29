package br.com.tw.lunchandlearn.fixture;

import br.com.tw.lunchandlearn.infrastructure.office.OfficeEntity;

public class OfficeEntityFixture {

    private OfficeEntity officeEntity;

    private OfficeEntityFixture() {
        officeEntity = new OfficeEntity();
        officeEntity.name = "Belo Horizonte";
    }

    public static OfficeEntityFixture anOffice() {
        return new OfficeEntityFixture();
    }

    public OfficeEntity build() {
        return officeEntity;
    }

}
