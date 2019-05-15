export class Claim {
    claimId:number;
	custId?:number;
	policyNumber:number;
	claimAmount:number;
    damageType:string;
    dateOfClaim:string;
    dateSettled?:string;
    amountPaid?:number;
    claimStatus?:string;
}
