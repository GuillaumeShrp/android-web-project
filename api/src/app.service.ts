import { Injectable } from '@nestjs/common';
import { CovidTestCenter } from './CovidTestCenter';
import dataSample from './sites-prelevements-grand-public.json'


@Injectable()
export class AppService {

  private readonly covidCenters: CovidTestCenter[] = [];

  constructor () {
    for (const element in dataSample)
    {
      const data: CovidTestCenter = {
        ID: dataSample[element]['ID'].toString(),
        rs: dataSample[element]['rs'].toString(),
        adresse: dataSample[element]['adresse'].toString(),
        do_prel: dataSample[element]['do_prel'].toString(),
        do_antigenic: dataSample[element]['do_antigenic'].toString(),
        longitude: dataSample[element]['longitude'].toString(),
        latitude: dataSample[element]['latitude'].toString(),
        mod_prel: dataSample[element]['mod_prel'].toString(),
        public: dataSample[element]['public'].toString(),
        horaire: dataSample[element]['horaire'].toString(),
        check_rdv: dataSample[element]['check_rdv'].toString(),
        tel_rdv: dataSample[element]['tel_rdv'].toString(),
        web_rdv: dataSample[element]['web_rdv'].toString(),
        date_modif: dataSample[element]['date_modif'].toString()
      };
      this.covidCenters.push(data);
    }
  }

  async getCovidTestCenters(): Promise<CovidTestCenter[]> {
    return this.covidCenters;
  }

}
