import {Component, OnDestroy, OnInit} from '@angular/core';
import {LabSeqControllerService} from "../../open-api";
import {BehaviorSubject, Observable} from "rxjs";

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent implements OnInit, OnDestroy {
  private currentSubject?: BehaviorSubject<string>;

  max = 10000;
  min = 0;
  value = 0;
  resObs?: Observable<string>;

  constructor(private service: LabSeqControllerService) {
  }

  ngOnInit(): void {
    this.currentSubject = new BehaviorSubject<string>('');
    this.resObs = this.currentSubject.asObservable();
  }

  ngOnDestroy(): void {
  }

  click() {
    this.service.getLabSeqResult(this.value).subscribe(res => {
      this.currentSubject?.next(res.result || '');
    })
  }


}
